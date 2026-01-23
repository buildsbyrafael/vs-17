package automationexercise.data.factory;

import automationexercise.data.dto.LoginDto;
import automationexercise.util.DataFakerGeneretor;

public class LoginData {

    // instanciar a ferramenta Faker
    DataFakerGeneretor dataFakerGeneretor = new DataFakerGeneretor();

    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto loginStandardUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("standard_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    public LoginDto loginLockedOutUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("locked_out_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    public LoginDto loginProblemUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("problem_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    public LoginDto loginPerformanceGlitchUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("performance_glitch_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    public LoginDto loginErrorUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("error_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    public LoginDto loginVisualUser() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario("visual_user");
        loginDto.setSenha("secret_sauce");

        return loginDto;
    }

    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto LoginDadoDinamicos() {
        // Instanciar = conexão com LoginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setUsuario(dataFakerGeneretor.emailFaker());
        loginDto.setSenha(dataFakerGeneretor.senhaFaker());

        return loginDto;
    }

}
