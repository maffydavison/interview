package com.maffy.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maryannfinnerty
 * Date: 11/12/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToe {


    /*
       0,2     1,2     2,2
       0,1     1,1     2,1
       0,0     1,0     2,0
    */
    private List<Position> positions;

    public TicTacToe() {
        positions = new ArrayList<Position>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                positions.add(new Position(i, j));
            }
        }

    }

    public String whoWon() {
        String result = checkRows();
        if (result == null) {
            result = checkColumns();
        }
        if (result == null) {
            result = checkDiagonal();
        }

        return result == null ? "no one" : result;
    }

    private String checkRows() {
        String result = null;
        List<Position> check = new ArrayList<Position>();
        List<Position> check1 = new ArrayList<Position>();
        List<Position> check2 = new ArrayList<Position>();
        for (Position p : positions) {
            if (p.getX() == 0) {
                check.add(p);
            } else if (p.getX() == 1) {
                check1.add(p);
            } else {
                check2.add(p);
            }
        }

        if (check.get(0).getMark() != null) {
            result = check.get(0).getMark();
            if (check.get(1).getMark() != null && check.get(1).getMark().equalsIgnoreCase(result)){
                if (check.get(2).getMark() != null && !check.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        if (result == null && check1.get(0).getMark() != null) {
            result = check1.get(0).getMark();
            if (check1.get(1).getMark() != null && check1.get(1).getMark().equalsIgnoreCase(result)){
                if (check1.get(2).getMark() != null && !check1.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        if (result == null && check2.get(0).getMark() != null) {
            result = check2.get(0).getMark();
            if (check2.get(1).getMark() != null && check2.get(1).getMark().equalsIgnoreCase(result)){
                if (check2.get(2).getMark() != null && !check2.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }
        return result;
    }

    private String checkColumns() {
        String result = null;
        List<Position> check = new ArrayList<Position>();
        List<Position> check1 = new ArrayList<Position>();
        List<Position> check2 = new ArrayList<Position>();
        for (Position p : positions) {
            if (p.getY() == 0) {
                check.add(p);
            } else if (p.getY() == 1) {
                check1.add(p);
            } else {
                check2.add(p);
            }
        }

        if (check.get(0).getMark() != null) {
            result = check.get(0).getMark();
            if (check.get(1).getMark() != null && check.get(1).getMark().equalsIgnoreCase(result)){
                if (check.get(2).getMark() != null && !check.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        if (result == null && check1.get(0).getMark() != null) {
            result = check1.get(0).getMark();
            if (check1.get(1).getMark() != null && check1.get(1).getMark().equalsIgnoreCase(result)){
                if (check1.get(2).getMark() != null && !check1.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        if (result == null && check2.get(0).getMark() != null) {
            result = check2.get(0).getMark();
            if (check2.get(1).getMark() != null && check2.get(1).getMark().equalsIgnoreCase(result)){
                if (check2.get(2).getMark() != null && !check2.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }
        return result;
    }

    private String checkDiagonal() {
        String result = null;
        List<Position> check = new ArrayList<Position>();
        List<Position> check1 = new ArrayList<Position>();
        for (Position p : positions) {
            if (p.getX() == p.getY()) {
                check.add(p);
            } else if (p.getX() == 0 && p.getY() == 2
                    || p.getX() == 1 && p.getY() == 1
                    || p.getX() == 2 && p.getY() == 0) {
                check1.add(p);
            }
        }

        if (check.get(0).getMark() != null) {
            result = check.get(0).getMark();
            if (check.get(1).getMark() != null && check.get(1).getMark().equalsIgnoreCase(result)){
                if (check.get(2).getMark() != null && !check.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        if (result == null && check1.get(0).getMark() != null) {
            result = check1.get(0).getMark();
            if (check1.get(1).getMark() != null && check1.get(1).getMark().equalsIgnoreCase(result)){
                if (check1.get(2).getMark() != null && !check1.get(2).getMark().equalsIgnoreCase(result)) {
                    result = null;
                }
            } else {
                result = null;
            }
        }

        return result;
    }

    public void setPosition(int x, int y, String mark) {
        for (Position p : positions) {
            if (p.getX() == x && p.getY() == y) {
                if (p.getMark() == null) {
                    p.setMark(mark);
                }
            }
        }
    }

    public void setPosition(Position position) {
        setPosition(position.getX(), position.getY(), position.getMark());
    }

    public Position findMove(String mark) {
        Position result = null;
        for (Position p : positions) {
            if (p.getMark() != null && p.getMark().equalsIgnoreCase(mark)) {
                if (isCenter(p)) {
                    result = findOpenAdjacentToCenter(mark);
                    if (result != null) {
                        break;
                    }

                } else if (isCorner(p)) {
                    result = findOpenAdjacentToCorner(p);
                    if (result != null) {
                        break;
                    }
                }

            }
        }

        return result == null ? findOpenSpot() : result;
    }

    private boolean isCenter(Position p) {
        return p.getX() == 1 && p.getY() == 1;
    }

    private boolean isCorner(Position p) {
        return (p.getX() == p.getY() || p.getX() == 0 && p.getY() == 2 || p.getX() == 2 && p.getY() == 0);
    }

    private Position findOpenSpot() {
        Position result = null;
        for (Position p : positions) {
            if (p.getMark() == null) {
                result = p;
                break;
            }
        }
        return result;
    }

    private Position findOpenAdjacentToCenter(String mark) {
        Position result = null;
        // center is 1,1
        // check 0,1
        // check 2,1
        // check 1,0
        // check 1,2
        for (Position p : positions) {
            if (p.getX() == 0 && p.getY() == 1) {
                if (p.getMark() == null) {
                    result = p;
                    break;
                }
            } else if (p.getX() == 2 && p.getY() == 1) {
                if (p.getMark() == null) {
                    result = p;
                    break;
                }
            } else if (p.getX() == 1 && (p.getY() == 0 || p.getY() == 2)) {
                if (p.getMark() == null) {
                    result = p;
                    break;
                }
            }
        }
        return result;
    }

    private Position findOpenAdjacentToCorner(Position position) {
        Position result = null;
        // corners
        // 0,0  check 0,1   1,1   1,0
        // 0,2  check 0,1   1,1   1,2
        // 2,0  check 1,0   1,1   2,1
        // 2,2  check 1,2   1,1   2,1
        for (Position p : positions) {
            if (position.getX() == 0 & position.getY() == 0) {
                if (p.getX() == 0 && p.getY() == 1 && p.getMark() == null) {
                    result = p;
                    break;
                } else if (p.getX() == 1 && (p.getY() == 1 || p.getY() == 0) && p.getMark() == null) {
                    result = p;
                    break;
                }
            } else if (position.getX() == 0 && position.getY() == 2) {
                if (p.getX() == 0 && p.getY() == 1 && p.getMark() == null) {
                    result = p;
                    break;
                } else if (p.getX() == 1 && (p.getY() == 1 || p.getY() == 2) && p.getMark() == null) {
                    result = p;
                    break;
                }
            } else if (position.getX() == 2 & position.getY() == 0) {
                if (p.getX() == 2 && p.getY() == 1 && p.getMark() == null) {
                    result = p;
                    break;
                } else if (p.getX() == 1 && (p.getY() == 1 || p.getY() == 0) && p.getMark() == null) {
                    result = p;
                    break;
                }
            } else if (position.getX() == 2 && position.getY() == 2) {
                if (p.getX() == 2 && p.getY() == 1 && p.getMark() == null) {
                    result = p;
                    break;
                } else if (p.getX() == 1 && (p.getY() == 1 || p.getY() == 2) && p.getMark() == null) {
                    result = p;
                    break;
                }
            }
        }
        return result;
    }

    class Position {
        private int x;
        private int y;
        private String mark;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            this.mark = null;
        }

        public Position(int x, int y, String mark) {
            this.x = x;
            this.y = y;
            this.mark = mark;
        }

        public int getX() {
            return x;
        }

       /* public void setX(int x) {
            this.x = x;
        }*/

        public int getY() {
            return y;
        }

/*        public void setY(int y) {
            this.y = y;
        }*/

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        @Override
        public String toString() {
            return "X coord: " + x + " Y coord: " + y + " Marked with: " + mark;
        }
    }


    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();

        game.setPosition(0, 0, "Y");
        game.setPosition(1, 1, "X");
        game.setPosition(2, 2, "Y");

/*        for (Position p: game.getMarkedPositions()) {
            System.out.println(p.toString());
        }*/

        Position move = game.findMove("Y");
        move.setMark("Y");
        System.out.println("Suggested move: " + move.toString());
        game.setPosition(move);
        move = game.findMove("X");
        move.setMark("X");
        System.out.println("Suggested move: " + move.toString());
        game.setPosition(move);
/*        for (Position p: game.getMarkedPositions()) {
            System.out.println(p.toString());
        }*/
        String winner = game.whoWon();
        System.out.println("Who won? " + winner);

    }
}
