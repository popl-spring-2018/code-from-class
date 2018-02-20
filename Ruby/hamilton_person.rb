require_relative "person"

module HamiltonPerson
  attr_reader :hamilton_id

  # Class variable
  @@hamilton_id_tracker = 0

  def assign_id
    @hamilton_id = @@hamilton_id_tracker
    @@hamilton_id_tracker += 1
  end
end


class Student < Person
  include HamiltonPerson

  attr_accessor :class_year

  def initialize(name, age, year)
    @class_year = year
    super(name, age)
    assign_id
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

class Professor < Person
  include HamiltonPerson

  attr_reader :department

  def initialize(name, age, department)
    @department = department
    super(name, age)
    assign_id
  end
    
  def introduce(other_person)
    super(other_person)
    puts "I am in the #{@department} department."
  end
end
