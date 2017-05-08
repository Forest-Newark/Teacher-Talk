package com.forestnewark.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by forestnewark on 5/5/17.
 */
public class TranslationServiceTest {
    @Test
    public void translationPunctionation() throws Exception {

        TranslationService ts = new TranslationService();

        System.out.println(ts.translationMessage("Hello world. Hello World!HelloWorld.","es","en"));

    }


}