package alrosa.staa.gatekeeper.objects.global;

import alrosa.staa.gatekeeper.objects.Direction;

public abstract class Global {

    public Global() {}

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Direction getDirection();

    public String getSurname() {
        return null;
    };
    public void setSurname(String surname) {};
    public String getPatronymic() {
        return null;
    };
    public void setPatronymic(String patronymic) {};

}
