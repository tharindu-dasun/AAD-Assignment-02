package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.SuperDTO;
import lk.ijse.gdse.response.Response;

public interface SuperService <T extends SuperDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
