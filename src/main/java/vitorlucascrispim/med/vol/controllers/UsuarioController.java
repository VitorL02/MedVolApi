package vitorlucascrispim.med.vol.controllers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorlucascrispim.med.vol.dtos.user.DadosAutenticacaoDTO;
import vitorlucascrispim.med.vol.dtos.user.DadosTokenJWT;
import vitorlucascrispim.med.vol.infra.TokenService;
import vitorlucascrispim.med.vol.models.user.Usuario;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dadosAutenticacao){
        var authToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(),dadosAutenticacao.senha());
        var auth =  manager.authenticate(authToken);
        var tokenJWT = tokenService.gerarToken((Usuario) auth.getPrincipal());
        DecodedJWT decodedJWT =  JWT.decode(tokenJWT);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT,decodedJWT.getExpiresAtAsInstant()));

    }

}
