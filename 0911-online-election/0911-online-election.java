class TopVotedCandidate {

     
     List<Integer> p= new ArrayList<>();
     List<Integer> t=new ArrayList<>();

     List<Integer> w= new ArrayList<>();

    public TopVotedCandidate(int[] persons, int[] times) {

        

        for( int i=0;i<persons.length;i++){
            p.add(persons[i]);
            t.add(times[i]);
        }
        

      Map<Integer, Integer> m = new HashMap<>();
int max = -1, candidate = -1;

for (int i = 0; i < persons.length; i++) {
      int val = m.merge(persons[i], 1, Integer::sum);
        if (val >= max) {       
           max = val;
             candidate = persons[i];
     }
    w.add(candidate);
}
        
    }
    
    public int q(int target) {

        int l=0;
        int r=t.size()-1;
        int ans=-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(t.get(mid)<=target){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return ans==-1?w.get(0): w.get(ans);
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */