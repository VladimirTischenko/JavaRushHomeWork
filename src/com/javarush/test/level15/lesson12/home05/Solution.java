package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(){}
    Solution(String s){}
    Solution(int i){}
    public Solution(char c){}
    public Solution(byte b){}
    public Solution(short sh){}
    protected Solution(Integer sh){}
    protected Solution(long l){}
    protected Solution(double d){}
    private Solution(float s){}
    private Solution(Character s){}
    private Solution(Double s){}
}

