
# proc is a block turned into an object
def call_two_procs(arg, proc1, proc2)
  result1 = proc1.call(arg)
  result2 = proc2.call(result1)
  return result2
end

squares = Proc.new {|x| x * x}
adds5 = Proc.new {|n| n + 5}

puts call_two_procs(10, squares, adds5)


# Can explicitly turn a block into a proc:
def stores_proc(arg, &proc)
  proc.call(arg)
end

def at_least_two_args(arg1, arg2, *rest)
  puts "First two args are: #{arg1} and #{arg2}"
  puts "The other args are #{rest}"
end

class Object

  # def method_missing(method_name, *args, &block)
  #   puts "Yo, the #{method_name.inspect} method doesn't exist."
  #   puts "You called it on the object #{self.inspect}, which is in the class #{self.class}."
  #   puts "The args: #{args}"
  #   puts "The block: #{block}"
  # end

  # Call the first method that is contained in a substring in the missing method's name
  def method_missing(missing_method_symbol, *args, &block)
    missing_method_string = missing_method_symbol.to_s

    replacement_method_symbol = self.methods.sort.find do |method|
      missing_method_string[method.to_s]
    end
    
    puts "#{missing_method_symbol.inspect} method replaced by #{replacement_method_symbol.inspect}"

    if replacement_method_symbol
      self.send(replacement_method_symbol, *args, &block)
    end

  end

end
