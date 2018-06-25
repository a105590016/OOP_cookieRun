package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by snow on 2018/4/27.
 */

public class Stage1 extends Stage {

    private MovingBitmap obstacle1 = new MovingBitmap(R.drawable.floor01_1_2);
    private MovingBitmap obstacle2 = new MovingBitmap(R.drawable.floor01_1_3);
    private MovingBitmap obstacle3 = new MovingBitmap(R.drawable.floor01_1_4);
    private MovingBitmap obstacle4 = new MovingBitmap(R.drawable.floor01_1_5);
    private MovingBitmap obstacle5 = new MovingBitmap(R.drawable.floor01_1_6);
    private MovingBitmap obstacle6 = new MovingBitmap(R.drawable.floor01_1_7);
    private MovingBitmap obstacle7 = new MovingBitmap(R.drawable.floor01_1_8);
    private MovingBitmap obstacle8 = new MovingBitmap(R.drawable.finish);

    private float jellyHeight = 20;

    public Stage1(){
        super();
        coordinate_x = 0;
        coordinate_y = 0;
        background_x = 0;
        background_y = 0;
        numberOfFloor = 101;
        floor_x = new float[numberOfFloor];
        floor_y = new float[numberOfFloor];
        floor = new MovingBitmap[numberOfFloor];
        for(int i=0;i<numberOfFloor;i++){
            floor_x[i] = index_x;
            index_x += pixelOfFloor;
            floor_y[i] = 321;
            floor[i] = new MovingBitmap(R.drawable.floor01_1);
        }
        background = new MovingBitmap(R.drawable.ep01_1_map);

        map1 = new int[37][606];

        props.add(new Props(R.drawable.jelly,370,290,100,floorSpeed));  //1
        props.add(new Props(R.drawable.jelly,400,290,100,floorSpeed));  //2
        props.add(new Props(R.drawable.jelly,430,290,100,floorSpeed));  //3
        props.add(new Props(R.drawable.jelly,460,290,100,floorSpeed));  //4
        props.add(new Props(R.drawable.jelly,490,230,100,floorSpeed));  //5
        props.add(new Props(R.drawable.jelly,530,230,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,560,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,590,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,620,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,650,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,690,230,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,730,230,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,760,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,790,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,820,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,850,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,890,230,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,930,230,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,960,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,990,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,1020,290,100,floorSpeed));
        props.add(new Props(R.drawable.jelly,1050,290,100,floorSpeed));
        for(int i=0;i<14;i++)
            props.add(new Props(R.drawable.yellow_bear,1080+30*i,290,200,floorSpeed));
        for(int i=0;i<6;i++)
            props.add(new Props(R.drawable.jelly,1580+30*i,290,100,floorSpeed));
        for (int i=0;i<9;i++)
            props.add(new Props(R.drawable.pink_bear,1760+30*i,290,300,floorSpeed));
        for (int i=0;i<5;i++)
            props.add(new Props(R.drawable.gold_money,2030+30*i,260,250,floorSpeed));
        for (int i=0;i<5;i++)
            props.add(new Props(R.drawable.gold_money,2030+30*i,290,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,2180+30*i,150,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,2180+30*i,180,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,2180+30*i,210,400,floorSpeed));
        for (int i=0;i<1;i++)
            props.add(new Props(R.drawable.blue_bear,2180+90*i,240,400,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,2300+30*i,260,250,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,2300+30*i,290,250,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.blue_bear,2480+30*i,240,400,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.blue_bear,2480+30*i,210,400,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.gold_money,2570+30*i,260,250,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.gold_money,2570+30*i,290,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,2650,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,2680,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,2710,140+30*i,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,2740,140+30*i,400,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,2740+30*i,260,250,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,2740+30*i,290,250,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.blue_bear,2920+30*i,210,400,floorSpeed));
        for (int i=0;i<3;i++)
            props.add(new Props(R.drawable.blue_bear,2920+30*i,240,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.gold_money,3010+30*i,260,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.gold_money,3010+30*i,290,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,3110,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3140,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3170,140+30*i,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,3200,140+30*i,400,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,3200+30*i,260,250,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,3200+30*i,290,250,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3380,210+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3410,210+30*i,400,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,3440+30*i,260,250,floorSpeed));
        for (int i=0;i<6;i++)
            props.add(new Props(R.drawable.gold_money,3440+30*i,290,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,3620,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3650,140+30*i,400,floorSpeed));
        for (int i=0;i<2;i++)
            props.add(new Props(R.drawable.blue_bear,3680,140+30*i,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,3710,140+30*i,400,floorSpeed));
        for (int i=0;i<33;i++)
            props.add(new Props(R.drawable.gold_money,3740+30*i,260,250,floorSpeed));
        for (int i=0;i<33;i++)
            props.add(new Props(R.drawable.gold_money,3740+30*i,290,250,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,3880+30*i,170,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,4000+30*i,150,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,4120+30*i,130,400,floorSpeed));
        for (int i=0;i<4;i++)
            props.add(new Props(R.drawable.blue_bear,4240+30*i,110,400,floorSpeed));
        for (int i=0;i<8;i++)
            props.add(new Props(R.drawable.blue_bear,4360+30*i,90,400,floorSpeed));
        for (int i=0;i<12;i++)
            props.add(new Props(R.drawable.gold_money,4780+30*i,290,250,floorSpeed));
        for (int i=0;i<5;i++)
            props.add(new Props(R.drawable.gold_money,4780+30*i,260,250,floorSpeed));

        props.add(new Props(R.drawable.hp,5290,140,1000,30,floorSpeed));


        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),500,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),700,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),900,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_5),1100,280-obstacle4.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_5),1300,280-obstacle4.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),1520,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_5),1770,280-obstacle4.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_5),1920,280-obstacle4.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),2190,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),2230,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),2500,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_7),2670,320-obstacle6.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),2940,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_7),3130,320-obstacle6.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),3380,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_7),3640,320-obstacle6.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),3880,220-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),3940,220-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4000,200-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4060,200-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4120,180-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4180,180-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4240,160-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4300,160-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4360,140-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4420,140-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4480,140-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_2),4540,140-obstacle1.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_3),4730,320-obstacle2.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.floor01_1_5),4950,280-obstacle4.getHeight());
        setObstacleLocation(new MovingBitmap(R.drawable.finish),5650,320-obstacle8.getHeight());

        for(int i=0;i<obstacle.size();i++){
            obstacleScreen_x.add(obstacle_x.get(i));
            obstacleScreen_y.add(obstacle_y.get(i));
        }
        for(int j=0;j<606;j++)
            map1[32][j] = 1;

        for(int i=29;i<32;i++){
            for(int j=51;j<53;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=71;j<73;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=91;j<93;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=4;i<28;i++){
            for(int j=112;j<116;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=4;i<28;i++){
            for(int j=132;j<136;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=153;j<155;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=4;i<28;i++){
            for(int j=179;j<183;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=4;i<28;i++){
            for(int j=194;j<198;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=220;j<226;j++){
                if(j==222||j==223)
                    continue;
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=251;j<253;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=24;i<32;i++){
            for(int j=269;j<271;j++){
                map1[i][j] = 2;
            }
        }

        for(int i=29;i<32;i++){
            for(int j=295;j<297;j++){
                map1[i][j] = 2;
            }
        }

        for(int i=24;i<32;i++){
            for(int j=315;j<317;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=29;i<32;i++){
            for(int j=339;j<341;j++){
                map1[i][j] = 2;
            }
        }

        for(int i=24;i<32;i++){
            for(int j=366;j<368;j++){
                map1[i][j] = 2;
            }
        }

        for(int j=388;j<400;j++)
            map1[20][j] = 1;

        for(int j=400;j<412;j++)
            map1[18][j] = 1;

        for(int j=412;j<424;j++)
            map1[16][j] = 1;

        for(int j=424;j<436;j++)
            map1[14][j] = 1;

        for(int j=436;j<460;j++)
            map1[12][j] = 1;


        for(int i=29;i<32;i++){
            for(int j=474;j<476;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=4;i<28;i++){
            for(int j=497;j<501;j++){
                map1[i][j] = 2;
            }
        }
        for(int i=9;i<32;i++){
            for(int j=580;j<586;j++){
                map1[i][j] = 4;
            }
        }

        for(int i=0;i<props.size();i++)
            map1[props.get(i).getCoordinate_y()/10][props.get(i).getCoordinate_x()/10] = 5;

        for(int i=14;i<25;i++)
            for(int j=529;j<542;j++)
                map1[i][j]=5;
    }
}
