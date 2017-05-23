package com.forestnewark.service;

import com.forestnewark.bean.MessageTranslation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by forestnewark on 5/5/17.
 */
@Service
public class TranslationService {


    private String translate(String message, String toLang, String fromLang){

        String requestUrl = "http://www.transltr.org/api/translate";

        MessageTranslation messageToTranslate = new MessageTranslation(message,fromLang,toLang,"");

        RestTemplate restTemplate = new RestTemplate();

       return restTemplate.postForObject(requestUrl,messageToTranslate,MessageTranslation.class).getTranslationText();

    }

    public String translationMessage(String message,String toLang, String fromLang){

        StringBuilder sb = new StringBuilder();

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);

        String source = message;

        iterator.setText(source);

        int start = iterator.first();

        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {

            sb.append(this.translate(source.substring(start,end),toLang,fromLang));

            String test = source.substring(start,end);
            if(test.substring(test.length()-1,test.length()).equals(" ")){
                sb.append(test.substring(test.length()-2,test.length()-1));
            }
            if(!test.substring(test.length()-1,test.length()).equals(" ")) {
                sb.append(test.substring(test.length()-1,test.length()));
            }

        }
        return sb.toString();
    }



}
