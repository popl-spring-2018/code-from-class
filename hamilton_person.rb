require_relative "person"

class Student < Person

  attr_accessor :class_year

  def initialize(name, age, year)
    @class_year = year
    super(name, age)
  end

  def study
    puts "Working hard."
    birthday
  end

  def introduce(other_person)
    super(other_person)
    puts "And I am in the class of #{@class_year}"
  end
end
