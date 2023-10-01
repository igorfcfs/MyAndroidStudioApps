package com.example.rotine.ui.sobrenos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SobreNosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SobreNosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bem-vindo ao Rotine, o seu parceiro confiável para o planejamento de rotinas personalizadas! Estamos entusiasmados por você estar aqui e queremos compartilhar um pouco sobre quem somos e o que nos motiva.\n" +
                "\n" +
                "No Rotine, acreditamos que a organização diária pode levar a uma vida mais produtiva, equilibrada e realizada. Entendemos que todos têm suas próprias metas, desafios e objetivos únicos, e é por isso que criamos esta plataforma versátil.\n" +
                "\n" +
                "Nossa equipe é composta por apaixonados por tecnologia, designers criativos e desenvolvedores dedicados que se uniram para tornar a gestão de rotina mais simples, eficaz e agradável. Estamos comprometidos em oferecer uma experiência excepcional aos nossos usuários.\n" +
                "\n" +
                "O que nos diferencia é o foco na personalização. Acreditamos que o planejamento de rotinas não deve ser uma abordagem única para todos, mas sim adaptado às suas necessidades e estilo de vida. No Rotine, você tem o controle total para criar, organizar e atingir suas metas diárias, semanais e mensais.\n" +
                "\n" +
                "Nossa missão é capacitá-lo a alcançar o seu melhor, seja na conquista de objetivos de carreira, acadêmicos ou pessoais. Com ferramentas intuitivas, recursos de colaboração e uma interface amigável, estamos aqui para ajudá-lo a fazer o máximo de cada dia.\n" +
                "\n" +
                "Estamos comprometidos em manter a segurança e a privacidade dos seus dados como prioridade máxima. Adotamos medidas rigorosas de segurança para proteger suas informações pessoais, garantindo que você possa usar o Rotine com tranquilidade.\n" +
                "\n" +
                "Agradecemos por nos escolher como seu parceiro de planejamento de rotinas. Seja bem-vindo à nossa comunidade e junte-se a nós nesta jornada de autodescoberta, produtividade e conquista de metas. Estamos ansiosos para ajudá-lo a transformar suas rotinas em resultados extraordinários.\n" +
                "\n" +
                "Se você tiver alguma dúvida, sugestão ou feedback, não hesite em entrar em contato conosco. Estamos aqui para ouvir e melhorar constantemente.\n" +
                "\n" +
                "Obrigado por confiar no Rotine!\n" +
                "\n" +
                "A equipe do Rotine");
    }

    public LiveData<String> getText() {
        return mText;
    }
}