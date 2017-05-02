package com.at.dto.factory;

import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.model.entity.IdentifiedEntity;

import java.util.List;


public interface DTOFactoryMethods
{

    interface CreateModel<
            T, InDTO>
    {

        /**
         * Create model
         *
         * @param inDTO - incoming DTO with description for model
         * @return {@link T}
         */
        T createModel(
                final InDTO inDTO);

    }

    interface CreateIdentifierOutDTO<T extends IdentifiedEntity>
    {

        /**
         * Create IdentifierOutDTO object from model
         *
         * @param model - model object
         * @return {@link IdentifierOutDTO}
         */
        IdentifiedOutDTO createIdentifierOutDTO(
                final T model);

    }

    interface CreateLightOutDTO<T, OutDTO>
    {

        /**
         * Create light OutDTO object from model
         *
         * @param model - model object
         * @return {@link OutDTO}
         */
        OutDTO createLightOutDTO(
                final T model);

    }

    interface CreateOutDTO<T, OutDTO>
    {

        /**
         * Create OutDTO object from model
         *
         * @param model - model object
         * @return {@link OutDTO}
         */
        OutDTO createOutDTO(
                final T model);

    }

    interface CreateFullOutDTO<T, FullOutDTO>
    {

        /**
         * Create full OutDTO object from model
         *
         * @param model - model object
         * @return {@link FullOutDTO}
         */
        FullOutDTO createFullOutDTO(
                final T model);

    }

    interface UpdateModel<
            T, InDTO>
    {

        /**
         * Update model
         *
         * @param inDTO - incoming DTO with description for model
         * @param model - updated model
         */
        void updateModel(
                final InDTO inDTO,
                T model);

    }

    interface CreateListOutDTO<T, OutDTO>
    {

        /**
         * Create List<OutDTO> object from modelList
         *
         * @param modelList - list of model objects
         * @return {@link List<OutDTO>}
         */
        List<OutDTO> createListOutDTO(
                final List<T> modelList);

    }

    interface CreateListLightOutDTO<T, OutDTO>
    {

        /**
         * Create List<OutDTO> object from modelList
         *
         * @param modelList - list of model objects
         * @return {@link List<OutDTO>}
         */
        List<OutDTO> createListLightOutDTO(
                final List<T> modelList);

    }

    interface FillPrimaryInfo<T, OutDTO>
    {
        /**
         * Fill dto by information stored in model
         *
         * @param outDTO - dto object to fill
         * @param model - model object
         */
        void fillPrimaryInfo(
                OutDTO outDTO,
                final T model);
    }

    interface FillLightOutDTO<T, LightOutDTO>
    {
        /**
         * Fill light dto by information stored in model
         *
         * @param lightOutDTO - light dto object to fill
         * @param model - model object
         */
        void fillLightOutDTO(
                LightOutDTO lightOutDTO,
                final T model);
    }


}