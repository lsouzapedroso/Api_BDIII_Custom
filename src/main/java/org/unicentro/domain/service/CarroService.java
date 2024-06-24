package org.unicentro.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.unicentro.domain.dto.carro.CarroRequestDTO;
import org.unicentro.domain.dto.carro.CarroResponseDTO;
import org.unicentro.domain.exception.ResourceNotFoundException;
import org.unicentro.domain.model.Carro;
import org.unicentro.domain.model.Usuario;
import org.unicentro.domain.repository.CarroRepository;

@Service
public class CarroService implements ICRUDService<CarroRequestDTO, CarroResponseDTO>  {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CarroResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       List<Carro> carros = carroRepository.findByUsuario(usuario);
       return carros.stream().map(carro -> mapper.map(carro, CarroResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CarroResponseDTO obterPorId(Long id) {
       Optional<Carro> optCarro = carroRepository.findById(id);
       if(optCarro.isEmpty()){
        throw new ResourceNotFoundException("Não foi possível encontrar o carro com o id: "+id);
       }
       return mapper.map(optCarro.get(), CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO cadastrar(CarroRequestDTO dto) {
        Carro carro = mapper.map(dto, Carro.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        carro.setUsuario(usuario);
        carro.setId(null);
        carro = carroRepository.save(carro);
        return mapper.map(carro, CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO atualizar(Long id, CarroRequestDTO dto) {
        obterPorId(id);
        Carro carro = mapper.map(dto, Carro.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
        carro.setUsuario(usuario);
        carro.setId(id);
        carro = carroRepository.save(carro);
        return mapper.map(carro, CarroResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
       obterPorId(id);
       carroRepository.deleteById(id);
    }
}

