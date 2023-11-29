/***
 *  1~1000 : n  과학자가 발표한 논문 수
 *  0~10000 : h 인용된 논문의 횟수
 *  이때,논문 n편 중 각각 h편 이상이고,나머지가 h편이하 인용되었다면
 *  h편의 최댓값이 h-index
 *  ...즉 논문들 각각 인용된 것 최대값 이라는소리
 *
 *  3 0 6 1 5 .... h-index = 3 , 3회이상 인용된게 0,2,4[index] 4회 이상은 3,4
 *  0 0 1 ...h index = 0
 */

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()
        var hIndex = 1

        for(i in 1.. citations.size){
            //hIndex 는 논문수를 넘어가선 안된다
            if(i<=citations[i-1]) hIndex = i
        }

        /**
         * i = 1 (1,[10])    hIndex = 1
         * i = 2 (2,[10,8])  hIndex = 2
         * i = 3 (3,[10,8,5]) hIndex = 3
         * i = 4 (4,[10,8,5,4]) hIndex = 4
         * i = 5 (5,[10,8,5,4,3]) hIndex = 4
         *
         * i 랑 cit[i-1]를 비교
         * > 만약. i>=cit[i-1] hIndex = i
         * i<=cit[i-1]
         */
        answer = hIndex
        return answer
    }
}

fun main(){

    var a = Solution()
//    a.solution(intArrayOf(3,0,6,1,5))
//    a.solution(intArrayOf(0,0,1))
    a.solution(intArrayOf(10,8,5,4,3))
    a.solution(intArrayOf(25,8,5,3,3))
}