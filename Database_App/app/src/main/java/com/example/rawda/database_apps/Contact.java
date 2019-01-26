package com.example.rawda.database_apps;

public class Contact {
    int _id;
    String _name, _phoneNumber;

    public Contact() {
        _id = 0;
        _name = "";
        _phoneNumber = "";
    }

    public Contact(int _id, String _name, String _phoneNumber) {
        this._id = _id;
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public Contact(String _name, String _phoneNumber) {
        this._name = _name;
        this._phoneNumber = _phoneNumber;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }
}
