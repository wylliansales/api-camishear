package io.github.camishear.dto.cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class ClienteRequestDto {

    @ApiModelProperty(value = "Nome do cliente", example = "Josefa Pinto da Silva")
    @NotEmpty(message = "Nome do cliente é obrigatório")
    @Size(min = 3, max = 150, message = "O nome do cliente precisar entre 3 e 150 caracteres")
    private String nome;

    @ApiModelProperty(value = "Telefone do cliente", example = "(63)98798-2545")
    private String telefone;

}
