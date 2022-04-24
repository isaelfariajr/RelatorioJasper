package com.br.jasper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client {

    private int id;
    private String name;
    private String andress;
    private String complement;
    private String state;
    private String phone;
}
