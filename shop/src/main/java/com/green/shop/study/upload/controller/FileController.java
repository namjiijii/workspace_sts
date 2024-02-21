package com.green.shop.study.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//파일 업로드,다운로드 학습용 컨트롤러
@Controller
@RequestMapping("/file")
public class FileController {

    //파일 첨부 페이지로 이동
    @GetMapping("/uploadForm")
    public String uploadForm(){
        //파일 확장자 추출
        String file1 = "abcb.jpg";
        System.out.println(file1.substring(file1.lastIndexOf(".")));


        // .의 위치를 알려줌
        System.out.println(file1.indexOf("."));
        //가장 마지막에 있는 .의 위치를 알려줌
        System.out.println(file1.lastIndexOf(""));

        return "test/upload/upload_form";
    }

    //파일 업로드
    @PostMapping("/upload")
    //MultipartFile는 html에서 넘어오는 file 데이터를 받아주는 자료형
    public String upload(@RequestParam(name = "img1") MultipartFile img1,
                         @RequestParam(name = "img2") MultipartFile img2){
        //첨부한 파일명
        String originFileName = img1.getOriginalFilename();
        System.out.println(originFileName);

        //업로드 경로
        String uploadPath = "D:\\01-STUDY\\dev\\workspace_sts\\shop\\src\\main\\resources\\static\\upload\\";

        //특수문자를 문자열로 취급하기위해 특수문자 앞에 \를 붙여주면 됨.
        // "안녕" 이라는 특수문자를 포함한 문자열을 출력하기 위해선
        // "\"안녕\""; 으로 출력을 해야함
        String hi = "\"안녕\"";


        //업로드 할 경로 및 파일명을 하나의 문자열로 나열
        String fileName = uploadPath + originFileName;
        //File class는 java.io.File을 선택해야 함

        //파일 업로드
        try {
            File file = new File(fileName); //하나의 파일을 만드는 것
            img1.transferTo(file); //하나의 파일을 만든 것을 img1으로 변환시킨 것
        } catch (IOException e) {
            System.out.println("-----파일 첨부 중 오류 발생-----");
            throw new RuntimeException(e);
        }

        //두번째 파일 업로드
        //원본 파일의 확장자만 추출
        String secondOriginFileName = img2.getOriginalFilename();
        String extension = secondOriginFileName.substring(secondOriginFileName.lastIndexOf("."));


        //서버에 저장할 파일명을 생성
        //UUID 랜덤한 문자열을 만들어줌
        String uuid = UUID.randomUUID().toString();
        //첨부될 파일명
        String attachedFileName = uuid + extension;

        try {
            File file1 = new File(uploadPath + attachedFileName);
            img2.transferTo(file1);
        } catch (IOException e) {
            System.out.println("-----파일 첨부 중 오류 발생-----");
            e.printStackTrace();
        }
        return "";
    }

    //다중 첨부 페이지로 이동(여러 개의 파일을 첨부)
    @GetMapping("/multiForm")
    public String multiForm(){
        return "test/upload/multi_form";
    }

    //다중 첨부 실행
    @PostMapping("/multi")
    public String multi(@RequestParam(name="imgs") MultipartFile[] imgs){
        //첨부할 파일 경로
        String uploadPath = "D:\\01-STUDY\\dev\\workspace_sts\\shop\\src\\main\\resources\\static\\upload\\";

        for(MultipartFile img : imgs){
            System.out.println(img.getOriginalFilename());

            //확장자 추출
            String extension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));

            //첨부될 파일명
            String attachedFileName = UUID.randomUUID().toString() + extension;

            //파일 첨부
            try {
                File file = new File(uploadPath + attachedFileName);
                img.transferTo(file);
            }catch (Exception e){
                System.out.println("-----파일 첨부 중 오류 발생-----");
                e.printStackTrace();
            }
        }

        return "";
    }




}
