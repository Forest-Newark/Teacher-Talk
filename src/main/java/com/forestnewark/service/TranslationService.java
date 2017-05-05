package com.forestnewark.service;

import com.forestnewark.bean.MessageTranslation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by forestnewark on 5/5/17.
 */
@Service
public class TranslationService {


    public String translateMessage(String message ,String toLang, String fromLang){

        String requestUrl = "http://www.transltr.org/api/translate";

        MessageTranslation messageToTranslate = new MessageTranslation(message,fromLang,toLang,"");

        RestTemplate restTemplate = new RestTemplate();

       return restTemplate.postForObject(requestUrl,messageToTranslate,MessageTranslation.class).getTranslationText();

    }
}
