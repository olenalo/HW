/**
 * HW6 by OPersian.
 *
 * Solve the Tower of Hanoi puzzle.
 *
 * Requirements:
 * - arbitrary number of rods,  // TODO
 * - arbitrary number of disks,
 * - with the numbers being equal to each other;  // TODO
 * - follow the Brahma Laws.
 *
 * Output examples:
 *     Disk #1: from Peg #1 to Peg #2 (d1: 1 >>>> 2)
 *     Disk #2: from Peg #2 to Peg #1 (d2: 2 >>>> 1)
 *     Disk #3: from Peg #1 to Peg #3 (d3: 1 >>>> 3)
 * - with Disk #1 being the smallest one.
 *
 * Reference:
 *     https://en.wikipedia.org/wiki/Tower_of_Hanoi
 */

public class TowerOfHanoi {

    static void moveTowerOfHanoiDisks(int diskNumber, char sourcePeg, char targetPeg, char auxiliaryPeg) {
        if (diskNumber > 0) {
            moveTowerOfHanoiDisks(diskNumber-1, sourcePeg, auxiliaryPeg, targetPeg);
            System.out.println("Disk #" + diskNumber + ": from Peg " +  sourcePeg + " to Peg " + targetPeg +
                    " (d" + diskNumber + ": " + sourcePeg + " >>>> " + targetPeg + ")");
            moveTowerOfHanoiDisks(diskNumber-1, auxiliaryPeg, targetPeg, sourcePeg);
        }
    }

    public static void main(String args[]) {
        int disksNumber = 3;
        if (args.length != 0) {
            disksNumber = Integer.valueOf(args[0]);
        } else {
            System.out.println("Using the default number of disks (which is " + disksNumber + "), " +
                    "as no other was provided.");
        }
        moveTowerOfHanoiDisks(disksNumber, 'A', 'C', 'B');
    }
}