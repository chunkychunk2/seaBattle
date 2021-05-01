package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> ship1 = new ArrayList<>();
        ArrayList<String> ship2 = new ArrayList<>();
        ArrayList<String> ship3 = new ArrayList<>();

        // выбираем точку начала корабля по вертикали
        String[] abc = {"A", "B", "C"};
        String[] def = {"D", "E", "F"};
        String[] ghi = {"G", "H", "I"};

        int abcLength = abc.length;
        int defLength = def.length;
        int ghiLength = ghi.length;

        int abcRndmPlace = (int) (Math.random() * abcLength);
        int defRndmPlace = (int) (Math.random() * defLength);
        int ghiRndmPlace = (int) (Math.random() * ghiLength);

        String ship1Place = abc[abcRndmPlace];
        String ship2Place = def[defRndmPlace];
        String ship3Place = ghi[ghiRndmPlace];

        // выбираем точку начала корабля по горизотали
        int[] first3Ranks = {1, 2, 3, 4, 5, 6};
        int[] second3Ranks = {1, 2, 3, 4, 5, 6};
        int[] third3Ranks = {1, 2, 3, 4, 5, 6};

        int first3RanksLength = first3Ranks.length;
        int second3RanksLength = second3Ranks.length;
        int third3RanksLength = third3Ranks.length;

        int first3RanksRndmPlace = (int) (Math.random() * first3RanksLength);
        int second3RanksRndmPlace = (int) (Math.random() * second3RanksLength);
        int third3RanksRndmPlace = (int) (Math.random() * third3RanksLength);

        int[] fisrtShipPlace = {first3RanksRndmPlace + 1, first3RanksRndmPlace + 2, first3RanksRndmPlace + 3};
        int[] secondShipPlace = {second3RanksRndmPlace + 1, second3RanksRndmPlace + 2, second3RanksRndmPlace + 3};
        int[] thirdShipPlace = {third3RanksRndmPlace + 1, third3RanksRndmPlace + 2, third3RanksRndmPlace + 3};

        // размещаем корабли
        ship1.add(ship1Place + fisrtShipPlace[0]);
        ship1.add(ship1Place + fisrtShipPlace[1]);
        ship1.add(ship1Place + fisrtShipPlace[2]);

        ship2.add(ship2Place + secondShipPlace[0]);
        ship2.add(ship2Place + secondShipPlace[1]);
        ship2.add(ship2Place + secondShipPlace[2]);

        ship3.add(ship3Place + thirdShipPlace[0]);
        ship3.add(ship3Place + thirdShipPlace[1]);
        ship3.add(ship3Place + thirdShipPlace[2]);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int shootCount = 0; // счетчик ходов
        int sheepCount = 3; // кол-во живых кораблей
        System.out.println("Поле 7х7, в игре 3 трехпалубных корабля");
        while (sheepCount > 0) { // Пользователь делает выстрел, пока не потопит все корабли
            System.out.println("Ваш ход: ");
            String shoot = reader.readLine();
            shootCount++;
            String result = "Мимо";
            for (String x : ship1) {
                if (shoot.equals(x)) {
                    result = "Попал";
                    ship1.remove(x);
                    if (ship1.size() == 0) {
                        sheepCount--;
                        result = "Корабль №1 потоплен! Осталось " + sheepCount + " кораблей";

                    }
                    break;
                }
            }
            for (String x : ship2) {
                if (shoot.equals(x)) {
                    result = "Попал";
                    ship2.remove(x);

                    if (ship2.size() == 0) {
                        sheepCount--;
                        result = "Корабль №2 потоплен! Осталось " + sheepCount + " кораблей";
                    }
                    break;
                }
            }
            for (String x : ship3) {
                if (shoot.equals(x)) {
                    result = "Попал";
                    ship3.remove(x);

                    if (ship3.size() == 0) {
                        sheepCount--;
                        result = "Корабль №3 потоплен! Осталось " + sheepCount + " кораблей";
                    }
                    break;
                }
            }
            System.out.println(result);
        }
        System.out.println("Победа! Вам потребовалось: " + shootCount + " выстрелов.");
    }
}
