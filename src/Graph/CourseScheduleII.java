package Graph;


import java.util.*;


//https://leetcode.com/problems/course-schedule-ii/submissions/1583502335/
class CourseScheduleIISolution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> depended = new ArrayList<>(Collections.nCopies(numCourses,0));
        List<Integer> ans = new ArrayList<>();
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
                ans.add(i);
            }
        }
        canFinishBFS(arr, queue,depended,ans);
        for(int i:depended){
            if(i!=0){
                return new int[]{};
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void canFinishBFS(List<List<Integer>> graph,Queue<Integer> queue,List<Integer>depended,List<Integer> ans){

        while (queue.size()>0){
            for(int i:graph.get(queue.peek())){
                if (depended.get(i)!=0){
                    depended.set(i,depended.get(i)-1);

                }
                if(depended.get(i)==0){
                    queue.add(i);
                    ans.add(i);
                }
            }
            queue.remove();
        }
    }
}
public class CourseScheduleII {
    public static void main(String args[]){
        CourseScheduleIISolution courseScheduleIISolution =new CourseScheduleIISolution();
    System.out.println(courseScheduleIISolution.findOrder(4,new int[][]{{0,1},{1,3},{3,2},{3,0}}));
    }
}
