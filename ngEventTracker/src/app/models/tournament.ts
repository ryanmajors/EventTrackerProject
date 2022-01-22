export class Tournament {
  id: number | undefined;
  name: string | undefined;
  tier: string | undefined;
  location: string | undefined;
  month: number;
  year: number;
  multiDay: boolean | undefined;
  days: number;
  players: number;
  entryFee: number;
  placement: number;
  points: number;
  hidden: boolean | undefined;

  constructor(
    id: number = 0,
    name?: string,
    tier?: string,
    location?: string,
    month: number = 1,
    year: number = 2022,
    multiDay?: boolean,
    days: number = 1,
    players: number = 0,
    entryFee: number = 0,
    placement: number = 0,
    points: number = 0,
    hidden: boolean = false
    ) {
      this.id = id;
      this.name = name;
      this.tier = tier;
      this.location = location;
      this.month = month;
      this.year = year;
      this.multiDay = multiDay;
      this.days = days;
      this.players = players;
      this.entryFee = entryFee;
      this.placement = placement;
      this.points = points;
      this. hidden = hidden;
    };
}
