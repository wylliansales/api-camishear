package io.github.camishear.dto.prodecimento;


import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Estrutura padrão de requisição para cadastrar procedimento.")
public class ProcedimentoSalvarRequestDto {

    @ApiModelProperty(value ="Nome do procedimento", example = "Selagem", required = true)
    @NotEmpty(message = "O nome do procedimento é obrigatório")
    @Size(min = 3, max = 150, message = "O nome do procedimento precisa ter no minimo 3 caracteres e no máximo 150.")
    private String nome;

    @ApiModelProperty(value = "Valor do procedimento", example = "150", required = true)
    @NotNull(message = "O valor é obrigatório")
    private BigDecimal valor;

    @ApiModelProperty(value = "Comissão do cabeleiro.", example = "45", required = true)
    @NotNull(message = "A comissão é obrigatória")
//    @Max(value = 100, message = "A porcetagem não pode ser mais que 100%")
//    @Min(value = 0, message = "A porcentagem não pode ser menor que 0%")
    @Range(min = 0, max = 100, message = "A comissão precisa ser maior que 0 e menor que 100")
    private byte comissao;
}
