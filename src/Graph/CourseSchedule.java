package Graph;

import java.util.*;

// https://leetcode.com/problems/course-schedule/

// O(Numcourses+Prerequisites.Length)
class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> depended = new ArrayList<>(Collections.nCopies(numCourses,0));
        for(int i=0;i<numCourses;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            arr.get(u).add(v);
            depended.set(v,depended.get(v)+1);
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(depended.get(i)==0){
                queue.add(i);
            }
        }
        List<Integer> visited =new ArrayList<>(Collections.nCopies(numCourses,0));
        List<Integer> ans=new ArrayList<>();
        for(int i :queue){
           if(!canFinishDFS(arr,visited,i,ans)){
        //               return false;
        System.out.println("ans is false");
        break;
           }
        }
    System.out.println(ans.toString());
    canFinishBFS(arr, queue,depended);
    for(int i:depended){
        if(i!=0){
            return false;
        }
    }
    return true;
    }

    public boolean canFinishDFS(List<List<Integer>> graph, List<Integer> visited,int node,List<Integer> ans){
       if(visited.get(node)==1){
           return false;
       }
       if(ans.contains(node)){
           return true;
       }
        visited.set(node,1);

        for(int i:graph.get(node)){
            if(!(canFinishDFS(graph,visited,i,ans))){
                return false;
            }
        }
        ans.add(0,node);
        return true;
    }

    public void canFinishBFS(List<List<Integer>> graph,Queue<Integer> queue,List<Integer>depended){

        while (queue.size()>0){
            for(int i:graph.get(queue.peek())){
                if (depended.get(i)!=0){
                    depended.set(i,depended.get(i)-1);

                }
                if(depended.get(i)==0){
                        queue.add(i);
                }
            }
            queue.remove();
        }
    }
}
public class CourseSchedule {
    public static void main(String args[]){
    CourseScheduleSolution courseScheduleSolution=new CourseScheduleSolution();
    System.out.println(courseScheduleSolution.canFinish(4,new int[][]{{0,1},{1,3},{3,2},{3,0}}));
    }
}
