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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Estrutura padrão para retorno de pesquisa os procedimento com paginação")
public class ProcedimentoListRequestDto {

    @ApiModelProperty(value = "Número da página", example = "1", required = true)
    @NotEmpty(message = "O numero da página é obrigatório")
    @Min(0)
    private int page;

    @ApiModelProperty(value = "Numero de itens por pagina", example = "10", required = true)
    @NotEmpty(message = "Quantidade de itens por página pecisa ser definido")
    private int size;

    @ApiModelProperty(value = "Nome do procedimento", example = "selagem")
    private String nome;
}
