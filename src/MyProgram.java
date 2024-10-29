import java.util.Scanner;

public class MyProgram {
    public static int health = 100;

    public static int ansCheck(int choice) {
        int newAns = choice;
        boolean check = false;
        Scanner input = new Scanner(System.in);

        while (check == false) {
            if (!(newAns > 0 && newAns < 4)) {


                System.out.println("Please enter a valid choice.");
                newAns = input.nextInt();

            } else {
                check = true;
            }
        }
        return newAns;
    }

    public static int ranNumGenerator() {
        int ranNum = (int) (Math.random() * 10);
        return ranNum;
    }

    public static boolean deathCheck(int health, int room) {
        if (health <= 0) {
            System.out.println("You've succumbed to your various injuries.");
            System.out.println("You made it to room " + room + ".");
            return true;
        } else {
            return false;
        }
    }

    public static int room0(int choice, int health, int room) {
        if (choice == 1) {
            System.out.println("You head left to investigate the shrieks. They get louder and louder until suddenly they go quiet.");
            System.out.println();
            int chance = ranNumGenerator();
            if (chance <= 5) {
                System.out.println("A viscous and otherworldy animal suddenly thrusts itself out of the darkness and onto, biting you and taking away 20 health.");
                health = health - 20; // Not lowering outside of method

                System.out.println();
                System.out.println("You now have " + health + " health.");
                System.out.println();

                if (deathCheck(health, room) == true) {
                    return -1;
                }

            } else {
                System.out.println("It seems whatever it was, it's gone.");
                System.out.println();

            }

            return 1;

        } else if (choice == 2) {
            System.out.println("You walk forward towards the sounds of rushing water. Soon you find yourself in a new room.");
            return 1;
        } else {
            System.out.println("You head right and find yourself in a long and winding corridor. You continue for what seems like ages as you stumble in the poorly torch lit hall. You hear the rushing water from before fade away behind you and suddenly you're in a new room.");
            return 2;
        }
    }

    public static int room1(int health, int room) {
        System.out.println("step into a vast room. The ceiling towers above, and directly across from you is a door, too high to reach. In the corner lies an old wooden log. You don't have long to assess the situation before water starts pouring into the room from cracks in the walls. The water rises quickly, and soon you're knee-deep. You'll need to act fast.");
        System.out.println("Do you: Try and scale the wall up to the door (1); Float to the top on the wood log (2); Drink all the water flowing in (3)");
        return 3;
    }

    public static void main(String[] args) {
        //stats
        //int health = 100;
        int room = 0;
        boolean poisoned = false;
        //inventory
        boolean chocolateBar = true;
        boolean silkRope = false;
        boolean sword = false;

        Scanner input = new Scanner(System.in);

        System.out.println(" You are standing in front of a mysterious dungeon. Your friends are laughing in the background. They just dared you to enter. Will you be able to find another way out? Will you even manage to survive? Your health starts at 100 and you've got one thing, a chocolate bar (type 4 in any decision to use).You push the heavy door open.  The path diverges into 3 directions. To the left you hear distant shrieks, you feel wind from the right, and you hear rushing waters ahead.");
        System.out.println("Do you go: Left (1), Forward (2), Right (3)?");

        int room0Choice = input.nextInt();
        input.nextLine();

        room0Choice = ansCheck(room0Choice);

        room = room0(room0Choice, health, room);

        if (room == 1) {
            room = room1(health, room);
            MyProgram.health = -2743; // silly but valid because health is a global variable that can be changed ANYWHERE
        }
/* INCOMPLETE CODE - NOT SURE WHAT YOU ARE TRYING TO DO HERE
        if
            System.out.println(health);
*/


    }
}