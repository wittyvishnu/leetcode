class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows=image.length;
        int cols=image[0].length;
        int[] dx={-1,0,0,1};
        int[] dy={0,-1,1,0};
        Queue<Pair> q=new ArrayDeque<>();
        q.offer(new Pair(sr,sc));
        int pixel=image[sr][sc];
        if(pixel==color)return image;
        image[sr][sc]=color;
        while(!q.isEmpty()){
            Pair temp=q.poll();
            for(int d=0;d<4;d++){
                int row=temp.r+dx[d];
                int col=temp.c+dy[d];
                if(row>=0&&row<rows&&col>=0&&col<cols&&image[row][col] == pixel){
                    q.offer(new Pair(row,col));
                    image[row][col]=color;
                }

            }

        }
        return image;
    }
}