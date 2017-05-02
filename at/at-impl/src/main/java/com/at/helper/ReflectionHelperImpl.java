package com.at.helper;


import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;


@Component
public class ReflectionHelperImpl implements ReflectionHelper
{

    // ********************************************************************************************************** start
    // *** override ReflectionHelper methods ***

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getGenericType(
            Field field)
    {

        // preconditions ..............................................................................................
        assert field != null;

        return (Class<?>) ((ParameterizedType) field.getGenericType())
                .getActualTypeArguments()[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getGenericArgumentType(
            Class<?> clazz,
            int argumentPosition)
    {
        // preconditions ..............................................................................................
        assert clazz != null;

        return (Class<?>) ((ParameterizedType) clazz.getGenericSuperclass())
                .getActualTypeArguments()[argumentPosition];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T createInstance(
            Class<T> clazz)
    {
        // preconditions ..............................................................................................
        assert clazz != null;

        try
        {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getFieldClass(
            Class<?> entityClazz,
            final List<String> fieldPath)
    {
        // preconditions ..............................................................................................
        assert entityClazz != null;
        assert fieldPath != null;

        Class<?> clazz = entityClazz;
        for (String fieldPathPart : fieldPath)
        {
            java.lang.reflect.Field classField =
                    ReflectionUtils.findField(clazz, fieldPathPart);
            clazz = classField.getType();

            if (Collection.class.isAssignableFrom(clazz))
            {
                clazz = getGenericType(classField);
            }
        }

        return clazz;
    }

    // ********************************************************************************************************** end


}
