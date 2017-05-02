package com.at.helper.system;


public interface AppMessageSourceHelper
{

    String getMessage(
            String code);

    String getMessage(
            String code,
            Object... args);

    String getMessage(
            String code,
            Object[] args,
            String defaultMessage);

}
