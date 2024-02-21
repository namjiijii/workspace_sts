package com.example.green.vm.car.service;

import com.example.green.vm.car.vo.CarVO;

import java.util.List;

public interface CarService {

    void insertCar(CarVO carVO);

    List<CarVO> selectCarList();
}
