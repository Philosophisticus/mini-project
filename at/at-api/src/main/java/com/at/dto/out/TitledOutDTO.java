package com.at.dto.out;

public abstract class TitledOutDTO<ID>
    extends IdentifiedOutDTO<ID>
    implements ITitledOutDTO
{

    private String title;

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public void setTitle(String title)
    {
        this.title = title;
    }

}
