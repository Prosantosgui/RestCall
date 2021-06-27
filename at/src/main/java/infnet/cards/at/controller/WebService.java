package infnet.cards.at.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebService {
    // Import do rest template pra usar as funções dele, como a "restTemplate.exchange" abaixo
    @Autowired
    RestTemplate restTemplate;

    // url do local host/
    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        // header dizendo q o tipo de mídia que retorna é uma midia do tipo JSON
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // Uma httpEntity precisa de um header e um body,header foi criado acima e o body vai ser adicionado abaixo com .getBody
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        // dentro do .exchange coloca o endpoint da api que você quer e vai retorna oq estiver nele
        return restTemplate.exchange("https://api.magicthegathering.io/v1/cards", HttpMethod.GET, entity, String.class).getBody();
        // o .getbody vai adicionar o conteudo do endpoint no body do mapping /template/products
    }
}
