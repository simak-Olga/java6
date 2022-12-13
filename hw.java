пакет Seminar6_final_HW;

импорт java. утилита.*;

Final_project_sem6HW общественного класса {

    public static void main(String[] args) {
        Ноутбук laptop1 = новый ноутбук(" Huawei MateBook D 15 15.6",
                "ADATA XPG Xenia 14, 14",
                MSI GF63 Thin 11UC-207XRU, 15.6");
        Ноутбук laptop2 = новый ноутбук("Huawei MateBook D 15 15.6",
                "Lenovo V15 G2 ITL, 15.6,
                "Digma EVE 15 P417, 15.6");
        Ноутбук laptop3 =  новый ноутбук("Acer Aspire 1 A114-33-P7VD, 14",
                "ACHUWI Corebook Xpro, 15.6",
                "ASUS Vivobook Go 15 E510MA-BQ509W, 15.6");
        Ноутбук laptop4 = новый ноутбук("Acer Aspire 3 A315-23-R3LH",
                "MSI Pulse GL66 12UGSZOK-1032XRU, 15.6",
                "Huawei MateBook D 15 15.6");
        Ноутбук laptop5 = новый ноутбук("HAIER GG1502XD", 15.6",
                "Acer Aspire 3 A315-23-R5HA, 15.6",
                "HIPER Workbook N1567, 15.6");
        Ноутбук laptop6 = новый ноутбук("Acer Aspire 3 A315-23-R3LH", 14.6,
                "MSI Modern 15 A11MU-1064XRU, 15.6",
                "ASUS VivoBook 15 OLED K513EA-L13067, 15.6" );


        System.out.println(laptop4.equals(laptop1));//true
        HashSet<Laptop> laptopsSet = новый HashSet<>(Массивы. asList(laptopl, laptop2, laptop3, laptop4, laptop5, laptop6));
        Система. вон. println("Размер множества: " + ноутбукиSet. размер());
        printSet(ноутбукиSet);
        попытка {
            HashSet<Laptop> filterSet = userFilter(laptopsSet);
            Система. вон. println("пользовательский фильтр:");
            printSet(filterSet);
        } catch (исключение e){
            Система. вон. println(e. getMessage());
        }
    }

    статический HashSet<Laptop> userFilter(HashSet<Laptop> ноутбуки){
        Сканер сканера = новый сканер (система. в);
        HashMap<Integer, String> userMapFilter = новый HashMap<>();
        HashMap<Integer, String> viewFilter = новый HashMap<>();
        viewFilter. put(1, "Модель - по вхождению строки");
        viewFilter. put(2, "Диагональ экрана - минимум");
        viewFilter. put(3, "Число ядер - минимум");
        viewFilter. put(4, "Частота процессора ГГц - минимум");
        viewFilter. put(5, "RAM - минимум");
        viewFilter. put(6, "SSD - минимум");
        viewFilter. put(7, "Операционная система - по вхождению строки");
        viewFilter. put(8, "Игровой? - Да/Нет");
        viewFilter. put(9, "Цвет - по вхождению строки");
        viewFilter. put(10, "Гарантия в месяцах - минимум");
        viewFilter. put(11, "Макс.часов автономной работы батареи - минимум");
        viewFilter. put(12, "Вес - минимум");
        viewFilter. put(13, "Цена - минимум");

        Система. вон. println("Введите число или числа через запятую, соответствующие критериям отбора.\nНапример, 5 или 1,3 и т.. ");
        для (Карта. Entry<Integer, String> el:viewFilter. записьНабор()) {
            Система. вон. println(el. getKey() + " - " + el. getValue());
        }
        Система. вон. println("Ожидается ввод: ");
        if (сканер. имеетСледующая()){
            Строковый ввод = сканер. следующий();
            ArrayList<Integer> userChoice = новый ArrayList<>();
            if (isDigit(input) && viewFilter. containsKey(Целое число. parseInt(input))) userChoice. add(Целое число. parseInt(input));
            еще {
                for (Строка str: input. сплит(",")) {
                    if (см. Фильтр. containsKey(Целое число. parseInt(str))){
                        userChoice. add(Целое число. parseInt(str));
                    }
                }
            }
            System.out.println(userChoice);
            если (! userChoice. IsEmpty()){
                for (Целочисленный элемент:userChoice) {
                    Система. вон. println("Введите значение отбора по - " + viewFilter. get(item));
                    if (сканер. имеетСледующая()){
                        input = сканер. следующий();
                        userMapFilter. put(элемент, вход);
                    }
                }
            } else Система. вон. println("Некорректный ввод");
        }
        сканер. закрывать();
        Система. вон. println("Задан фильтр: " + userMapFilter);
        HashSet<Laptop> tmpLaptops = новый HashSet<>(ноутбуки));

        для (Карта. Entry<Integer, String> entry:userMapFilter. записьНабор()) {
System.out.println("смотрим" + entry.getKey() + " " + entry.getValue());
            tmpLaptops. removeIf(ноутбук -> ! ноутбук. checkUsersFilter(entry. getKey(), запись. getValue()));
        }
        возврат tmpLaptops;
    }

    static void printSet(HashSet<Laptop> lap){
        for (Ноутбук ноутбук : lap) {
            if (ноутбук != null){
                Система. вон. println(ноутбук));
            }
        }
    }
    статический  логический объект isDigit(String s) выдает исключение NumberFormatException {
        попытка {
            Целое число. parseInt(s));
            Возвращает значение true;
        } catch (NumberFormatException e) {
            возвращает значение false;
        }
    }

}