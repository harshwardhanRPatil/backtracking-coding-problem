package Graph;

import java.util.*;


//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/?envType=daily-question&envId=2025-03-21

class FindAllPossibleRecipesSolution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Boolean> can_cook=new HashMap<>();
        for(String i:supplies){
            can_cook.put(i,true);
        }
    Map<String, Integer> recipes_index = new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            recipes_index.put(recipes[i],i);
        }

    System.out.println(recipes_index.toString());
        List<String> ans=new ArrayList<>();
        for(String r:recipes){
            if(cooking_dish(r,can_cook,recipes_index,ingredients)){
                ans.add(r);
            }
        }
        return  ans;
    }
    public boolean cooking_dish(String r,Map<String,Boolean> can_cook,Map<String, Integer> recipes_index,List<List<String>> ingredients){
        if(can_cook.containsKey(r)){
            return can_cook.get(r);
        }
//        if this is not a supply and recipes you can make it so we return false for this
        if(!recipes_index.containsKey(r)){
            return false;
        }
        can_cook.put(r,false);
        for(String ingredient:ingredients.get(recipes_index.get(r))){
            if (!cooking_dish(ingredient,can_cook,recipes_index,ingredients)){
                return false;
            }
        }
can_cook.put(r,true);
        return can_cook.get(r);
    }
}
public class FindAllPossibleRecipes {
    public static void main(){
        FindAllPossibleRecipesSolution findAllPossibleRecipesSolution=new FindAllPossibleRecipesSolution();
        List<List<String>> ingredients=new ArrayList<>();
        ingredients.add(new ArrayList<>(Arrays.asList("yeast","flour")));

    System.out.println(findAllPossibleRecipesSolution.findAllRecipes(new String[]{"bread"},ingredients,new String[]{"yeast","flour","corn"}));
    }
}
