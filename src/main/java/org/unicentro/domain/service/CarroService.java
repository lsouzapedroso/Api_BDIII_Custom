package org.unicentro.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.unicentro.domain.dto.carro.CarroRequestDTO;
import org.unicentro.domain.dto.carro.CarroResponseDTO;
import org.unicentro.domain.exception.ResourceNotFoundException;
import org.unicentro.domain.model.Carro;
import org.unicentro.domain.model.Usuario;
import org.unicentro.domain.repository.CarroRepository;

public class CarroService implements ICRUDService<CarroRequestDTO, CarroResponseDTO>  {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CarroResponseDTO> obterTodos() {
       Usuario usuario = (Usuario) SecurityContextHolder.getContext()
       .getAuthentication().getPrincipal();
       List<Carro> carros = carroRepository.findByUsuario(usuario);
       return carros.stream().map(carro -> mapper.map(carro,
       CarroResponseDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public CarroResponseDTO obterPorId(Long id) {
       Optional<Carro> optCarro = carroRepository.findById(id);
       if(optCarro.isEmpty()){
        throw new ResourceNotFoundException("Não foi possível encontrar o título com o id: "+id);
       }
       Usuario usuario = (Usuario) SecurityContextHolder.getContext()
       .getAuthentication().getPrincipal();
       if(optCarro.get().getUsuario().getId() != usuario.getId()){
         throw new ResourceNotFoundException("O título de id: " +
         id + "não pertence a esse usuário");
       }
       return mapper.map(optCarro, CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO cadastrar(CarroRequestDTO dto) {
        validarCarro(dto);

        Carro carro = mapper.map(dto, Carro.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext()
       .getAuthentication().getPrincipal();
     // System.out.println(titulo.getCentrosDeCustos().size());
        carro.setUsuario(usuario);
        carro.setId(null);
        carro.setDataCadastro(new Date());
        carro = carroRepository.save(carro);
        return mapper.map(carro, CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO atualizar(Long id, CarroRequestDTO dto) {
        obterPorId(id);
        validarCarro(dto);
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

    private void validarCarro(CarroRequestDTO dto){
        if((dto.getModelo() == null) || (dto.getMarca() == null) ||
        (dto.getCor() == null) || (dto.getPotencia() == null) || (dto.getAno() == null)){
            throw new BadRequestException("Título Inválido - Campos Obrigatórios");
        }
    }

    public List<CarroResponseDTO> obterPorDataDeVencimento(String periodoInicial,
    String periodoFinal){
       
        List<Carro> carros = carroRepository
        .obterFluxoCaixaPorDataVencimento(periodoInicial, periodoFinal);
       
        return titulos.stream().map(titulo -> mapper
        .map(titulo, TituloResponseDTO.class))
        .collect(Collectors.toList());
    }
    
}
}
