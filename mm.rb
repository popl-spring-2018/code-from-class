
# proc is a block turned into an object
def call_two_procs(arg, proc1, proc2)
  result1 = proc1.call(arg)
  result2 = proc2.call(result1)
  return result2
end

squares = Proc.new {|x| x * x}
adds5 = Proc.new {|n| n + 5}

puts call_two_procs(10, squares, adds5)

