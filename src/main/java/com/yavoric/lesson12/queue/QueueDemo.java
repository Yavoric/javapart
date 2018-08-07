package com.yavoric.lesson12.queue;
import java.util.Scanner;
public class QueueDemo {
    public static void main(String[] args) {
        int j = GetQueueLength();
        Integer[] arr = new Integer[j];
        Queue<Integer> queueInt = new QueueImpl<>(arr);
        Integer n = 0;
        //Integer m = 0;
        for (; ; ) {
            int q = SelectOperationQueue();
            switch (q) {
                case 1: queueInt.add(ElementQueue());
                        break;
                case 2: n = queueInt.pol();
                        System.out.println("Элемент очереди="+n);
                        break;
                case 3: n = queueInt.peek();
                        System.out.println("Элемент очереди="+n);
                        break;
                default:
                    System.out.println("Вы выбрали несуществующую операцию");
                    break;
            }
            int h = Stopapplication();
            if(h==2)
                break;
            //queueDemo();
        }
    }
        private static int ElementQueue() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите элемент очереди:");
            int d = scanner.nextInt();
            return d;

    }
        private static int Stopapplication() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Хотите продолжить? 1-ДА; 2-НЕТ");
            int d = scanner.nextInt();
            return d;
        }
        private static int GetQueueLength () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите длинну очереди:");
            int d = scanner.nextInt();
            return d;
        }
        private static int SelectOperationQueue () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите операцию: 1-Добавить элемент в очередь; 2-Извлечь элемент из очереди(Элемент будет удален); " +
                    "3- Показать первый элемент из очереди(Элемент не будет удален");
            int d = scanner.nextInt();
            return d;
        }

        /*private static void queueDemo () {
            Integer[] arr = new Integer[10];
            Queue<Integer> queueInt = new QueueImpl<>(arr);
            // Queue<Integer> queue1Int = new QueueImpl<>(arr);
            Integer n = 0;
            Integer m = 0;
            queueInt.add(18);
            queueInt.add(11);
            queueInt.add(17);
            n = queueInt.pop();
            m = queueInt.peek();
            System.out.println("Элемент из очереди=" + n);
            System.out.println("Элемент из очереди=" + m);

        }*/


}


