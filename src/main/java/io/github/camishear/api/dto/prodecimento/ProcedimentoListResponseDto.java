package io.github.camishear.api.dto.prodecimento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Estrutura de retorno para pesquisa de procedimento")
public class ProcedimentoListResponseDto {

    @ApiModelProperty(value = "Id de identificação do procedimento", example = "1")
    private Integer id;

    @ApiModelProperty(value = "Nome do procedimento", example = "Escova")
    private String nome;

    @ApiModelProperty(value = "Valor do procedimento", example = "150.30")
    private BigDecimal valor;

    @ApiModelProperty(value = "Comissão da cabeleleira", example = "50")
    private byte comissao;
}
