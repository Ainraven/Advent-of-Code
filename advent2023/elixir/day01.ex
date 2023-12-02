defmodule Trebuchet do

  # Day 1, part 1
  def calibrate1() do
    File.stream!("day01-1.txt")
      |> Stream.map(&String.trim/1)
      |> Stream.map(&String.replace(&1, ~r/[a-zA-Z]/, ""))
      |> Stream.map(&num/1)
      |> Enum.sum()
  end

  def num(str) do
    first = String.slice(str, 0, 1)
    last = String.slice(str, -1, 1)
    {num, _} = Integer.parse("#{first}#{last}")
    num
  end

  # Day 1, Part 2
  def calibrate2() do
    num = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]

    File.stream!("day01-1.txt")
    |> Stream.map(&String.trim/1)
    |> Stream.map(&loop(&1, 0, num, []))
    |> Enum.sum()
  end

  # Outer loop, goes through different numbers
  # Buffer stores tuples {position in string, number}
  def loop(_, 18, _, buf) do
    list = Enum.sort(buf)
    {_, a} = List.first(list)
    {_, b} = List.last(list)
    a * 10 + b
  end
  def loop(str, i, num, buf) do
    buf = while(str, Enum.at(num, i), buf, 0)
    loop(str, i + 1, num, buf)
  end
  # Inner loop, goes through the string for different instances of a number
  # Deleted stores amount of deleted characters from the string
  def while(0, _, buf, _), do: buf
  def while(str, number, buf, deleted) do
    out = :binary.match(str, number)
    {str, buf, deleted} = case out do
      :nomatch -> {0, buf, deleted}
      {a, b} ->
        buf = [{a + deleted, word_to_num(number)} | buf]
        deleted = deleted + String.length(number)
        {cut(str, a, b), buf, deleted}
      end
    while(str, number, buf, deleted)
  end

  # Remove an instance of a number from a string
  def cut(str, a, b) do
    head = String.slice(str, 0, a)
    tail = String.slice(str, a+b, String.length(str))
    "#{head}#{tail}"
  end

  def word_to_num("1"), do: 1
  def word_to_num("2"), do: 2
  def word_to_num("3"), do: 3
  def word_to_num("4"), do: 4
  def word_to_num("5"), do: 5
  def word_to_num("6"), do: 6
  def word_to_num("7"), do: 7
  def word_to_num("8"), do: 8
  def word_to_num("9"), do: 9
  def word_to_num("one"), do: 1
  def word_to_num("two"), do: 2
  def word_to_num("three"), do: 3
  def word_to_num("four"), do: 4
  def word_to_num("five"), do: 5
  def word_to_num("six"), do: 6
  def word_to_num("seven"), do: 7
  def word_to_num("eight"), do: 8
  def word_to_num("nine"), do: 9

end
