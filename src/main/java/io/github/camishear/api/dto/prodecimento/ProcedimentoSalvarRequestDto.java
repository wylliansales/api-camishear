package io.github.camishear.api.dto.prodecimento;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Estrutura padrão de requisição para cadastrar procedimento.")
public class ProcedimentoSalvarRequestDto {

    @NotEmpty(message = "O nome do procedimento é obrigatório")
    @Size(min = 3, max = 150, message = "O nome do procedimento precisa ter no minimo 3 caracteres e no máximo 150.")
    @ApiModelProperty(value ="Nome do procedimento", example = "Selagem", required = true)
    private String nome;

    @NotNull(message = "O valor é obrigatório")
    @ApiModelProperty(value = "Valor do procedimento", example = "150", required = true)
    private BigDecimal valor;

    @NotNull(message = "A comissão é obrigatória")
//    @Max(value = 100, message = "A porcetagem não pode ser mais que 100%")
//    @Min(value = 0, message = "A porcentagem não pode ser menor que 0%")
    @Range(min = 0, max = 100, message = "A comissão precisa ser maior que 0 e menor que 100")
    @ApiModelProperty(value = "Comissão do cabeleiro.", example = "45", required = true)
    private byte comissao;
}
