package io.github.mateusbosquetti.pixapi.service;

import io.github.mateusbosquetti.pixapi.model.dto.PixKafkaDTO;
import io.github.mateusbosquetti.pixapi.model.dto.PixRequestDTO;
import io.github.mateusbosquetti.pixapi.model.entity.Key;
import io.github.mateusbosquetti.pixapi.model.entity.Pix;
import io.github.mateusbosquetti.pixapi.model.enums.PixStatus;
import io.github.mateusbosquetti.pixapi.repository.PixRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PixService {

    private final PixRepository repository;
    private final KeyService keyService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Pix createPix(PixRequestDTO pixRequestDTO) {

        Key chaveOrigem = this.keyService.findByKey(pixRequestDTO.chaveOrigem());
        Key chaveDestino = this.keyService.findByKey(pixRequestDTO.chaveDestino());

        Pix pix = Pix.builder()
                .chaveDestino(chaveDestino)
                .chaveOrigem(chaveOrigem)
                .valor(pixRequestDTO.valor())
                .status(PixStatus.PROCESSADO)
                .build();

        pix = this.repository.save(pix);
        PixKafkaDTO kafkaDTO = new PixKafkaDTO(pix.getValor(), pix.getChaveDestino().getUserId());
        kafkaTemplate.send("CREATE_PIX_TOPIC", pix.getIdentificador().toString(),  kafkaDTO);
        return pix;
    }

}
