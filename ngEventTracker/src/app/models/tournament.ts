export class Tournament {
  id: number | undefined;
  name: string | undefined;
  tier: string | undefined;
  location: string | undefined;
  month: number | undefined;
  year: number | undefined;
  multiDay: boolean | undefined;
  days: number | undefined;
  players: number | undefined;
  entryFee: number | undefined;
  placement: number | undefined;
  points: number | undefined;
  hidden: boolean | undefined;

  constructor(
    id: number = 0,
    name?: string,
    tier?: string,
    location?: string,
    month?: number,
    year?: number,
    multiDay?: boolean,
    days?: number,
    players?: number,
    entryFee?: number,
    placement?: number,
    points?: number,
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
