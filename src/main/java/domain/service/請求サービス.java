package domain.service;

import domain.model.請求.消費税率;
import domain.model.請求.税込請求額;
import domain.model.請求.税抜請求額;

public class 請求サービス {


 public 税込請求額 請求すべき総額を計算する(税抜請求額 税抜請求額){

     消費税率 今日の消費税率 = 消費税率.整数より(10);

     税込請求額 今日の税込請求額 = 税込請求額.税抜請求額と消費税率より(税抜請求額, 今日の消費税率);

     return 今日の税込請求額;
 }

}
