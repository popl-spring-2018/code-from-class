
# Open classes
# We can take existing classes and add behavior, even if we didn't create those classes.

class String
  
  # Returns true if a string is entirely made of capital lettes
  def caps?
    caps_re = /\A[A-Z]*\Z/
    return caps_re.match?(self)
  end

end

class Integer

  # Map a block of code over all square numbers between 
  # 0 and self. Returns an array of the results.
  def map_over_squares
    x = 0
    results = []

    while x * x <= self
      block_return_value = yield x * x
      results << block_return_value
      x += 1
    end
    
    results
  end

  # def +(other_int)
  #   a = self
  #   while other_int > 0
  #     a = a.succ
  #     other_int -= 1
  #   end
  #   return a
  # end

  # def negative?
  #   if self < 0
  #     return false
  #   else
  #     return true
  #   end
  # end

  # def *(x)
  #   self + x
  # end
end
