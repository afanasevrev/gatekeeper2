package alrosa.staa.gatekeeper.objects.bureau.users;

import alrosa.staa.gatekeeper.objects.Direction;
import javafx.scene.image.Image;

public class Woman extends Users {
    private final String gender = "Женский";
    private String fullname;
    private String surname;
    private String name;
    private String patronymic;
    private Image photo;
    private final Direction direction = Direction.WOMAN;
    public Woman() {
        this.fullname = "Человек";
    }
    public Woman(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.fullname = surname + " " + name + " " + patronymic;
    }

    public String getGender() {
        return this.gender;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }
    public Image getPhoto() {
        return this.photo;
    }
    public void setPhoto(final Image photo) {
        this.photo = photo;
    }
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return  fullname;
    }
}
