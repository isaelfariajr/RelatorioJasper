package com.br.jasper.service;

import com.br.jasper.domain.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateClients {

    public List<Client> execute() {

        return getClientList();
    }

    private List<Client> getClientList() {

        List<Client> clientList = new ArrayList<>();
        clientList.add(getClient1());
        clientList.add(getClient2());
        clientList.add(getClient3());

        return clientList;
    }

    private Client getClient1() {

        return Client.builder()
                .name("Client 01")
                .andress("Street Client 01")
                .complement("Room 105")
                .phone("5555-6658")
                .state("SP")
               .build();
    }

    private Client getClient2() {

        return Client.builder()
                .name("Client 02")
                .andress("Street Client 02")
                .complement("Room 102")
                .phone("5555-6657")
                .state("MG")
                .build();
    }

    private Client getClient3() {

        return Client.builder()
                .name("Client 03")
                .andress("Street Client 03")
                .complement("Room X0")
                .phone("5555-6666")
                .state("BA")
                .build();
    }

}
