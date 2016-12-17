package client.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 11.12.2016
 * Group: 11-501
 * Project: influence
 */
public class GameMap {

    private List<Cell> cells;
    private List<Route> routes;

    public final int maxX = 14;
    public final int maxY = 9;

    public GameMap(List<Cell> cells, List<Route> routes) {
        this.cells = cells;
        this.routes = routes;
    }

    public static GameMap createGameMap(byte[] cellsBytes, byte[] routesBytes){

        //Cells creating
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < cellsBytes.length; i++){
            if (cellsBytes[i] != 0)
                cells.add(new Cell( i+1, cellsBytes[i]));
        }

        //Routes creating
        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < routesBytes.length-1; i+=2){
            routes.add(new Route(routesBytes[i], routesBytes[i+1]));
        }

        return new GameMap(cells, routes);
    }


    public void printGameMap(String view){

        System.out.println("--------------------------");
        for (int i = 1; i <= maxY; i++) {
            if (i % 2 == 1)
                System.out.print(" ");

            for (int j = 1; j < maxX; j++)
                printCell((i - 1) * (maxX - 1) + ((i - 1) / 2) + j, view);

            if (i % 2 == 0)
                printCell((i - 1) * (maxX - 1) + ((i - 1) / 2) + maxX, view);

            System.out.println();
        }
        System.out.println("--------------------------");
        System.out.println(routes);
    }

    public void printCell(int cellNum, String view){
        Cell cell  = getCell(cellNum);
        if (cell != null) {
            if (view.equals("type"))
                System.out.print(cell.getType() + " ");
            else if (view.equals("power"))
                System.out.print(cell.getPower() + " ");
            else if (view.equals("maxPower"))
                System.out.print(cell.getMaxPower() + " ");
            else if (view.equals("number"))
                System.out.print(cell.getNumber() + " ");
        } else {
            System.out.print("  ");
        }
    }

    public void printGameMap(){
        printGameMap("type");
    }

    public Cell getCell(int cellNum){

        for (Cell cell: cells)
            if (cell.getNumber() == cellNum)
                return cell;

        return null;
    }

    public int getCellsCountByType(int type){

        int count = 0;
        for (Cell cell: cells)
            if (cell.getType() == type)
                count++;

        return count;
    }

}