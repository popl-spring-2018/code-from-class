
class Person

  # This automatically creates getter and setter methods
  attr_accessor :age

  # attr_reader - defines the getter
  # attr_writer - defines the setter

  # def  age
  #   @age
  # end

  # def age=(value)
  #   @age = value
  # end
    
  def initialize(full_name, age)
    @name = full_name
    @age = age
    # @name and @age are fields
  end

end
