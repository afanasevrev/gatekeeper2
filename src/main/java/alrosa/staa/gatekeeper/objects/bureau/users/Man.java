package alrosa.staa.gatekeeper.objects.bureau.users;

import alrosa.staa.gatekeeper.objects.Direction;
import javafx.scene.image.Image;

public class Man extends Users {
    private final String gender = "Мужской";
    private String complete_name;
    private String surname;
    private String name;
    private String patronymic;
    private Image photo;
    private final Direction direction = Direction.MAN;
    public Man() {
        this.complete_name = "Человек";
    }
    public Man(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.complete_name = surname + " " + name + " " + patronymic;
    }
    public String getGender() {
        return this.gender;
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
    public String getComplete_name() {
        return this.complete_name;
    }
    @Override
    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }
    @Override
    public Direction getDirection() {
        return this.direction;
    }
    @Override
    public String toString() {
        return  getComplete_name();
    }
}
