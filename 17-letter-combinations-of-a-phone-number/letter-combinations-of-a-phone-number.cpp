class Solution {
public:
    vector<string> letterCombinations(string digits) {
       
       vector<vector<char>> digitMap;
       digitMap.push_back({'a','b','c'});
       digitMap.push_back({'d','e','f'});
       digitMap.push_back({'g','h','i'});
       digitMap.push_back({'j','k','l'});
       digitMap.push_back({'m','n','o'});
       digitMap.push_back({'p','q','r','s'});
       digitMap.push_back({'t','u','v'});
       digitMap.push_back({'w','x','y','z'});
       int ans=0;
       if(digits.length()==0)
       {
           return {};
       }
       else
       {
           string tmp="";
           int i=0;
           vector<string> ans;
           PrintAllComb(tmp, digits, i, digitMap, ans);
           return ans;
       
    }
    }
       
       void PrintAllComb(string tmp, string &digits, int i, vector<vector<char>> &digitMap, vector<string> &ans)
       {
           if(digits[i]=='\0')
           {
           ans.push_back(tmp);
           return;
           }

           for(int j=0;j<digitMap[digits[i]-'2'].size();j++)
           {
               PrintAllComb(tmp+digitMap[digits[i]-'2'][j],digits,i+1,digitMap,ans);
           }
       }

    
};