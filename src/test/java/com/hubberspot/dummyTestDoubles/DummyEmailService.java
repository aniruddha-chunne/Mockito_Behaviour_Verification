package com.hubberspot.dummyTestDoubles;

public class DummyEmailService implements EmailSerivce
{

    @Override
    public void sendEmail(String message)
    {
        throw new AssertionError("Method not implemented");
    }
}
